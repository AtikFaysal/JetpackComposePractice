package com.jetpack.compose

import com.jetpack.apientity.RepoApiResponseItemEntity
import com.jetpack.domain.apiusecase.RepoListApiUseCase
import com.jetpack.domain.base.ApiResult
import com.jetpack.domain.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val repoListApiUseCase: RepoListApiUseCase,
) : BaseViewModel(){

    val action: (RepoUiAction) -> Unit

    private val _uiState = MutableStateFlow<RepoUiState<Any>>(RepoUiState.Loading(false))
    val uiState get() = _uiState

    private val _uiStateEvent = Channel<RepoUiStateEvent<Any>>()
    val uiStateEvent get() = _uiStateEvent.receiveAsFlow()

    init {
        action = {
            when(it){
                is RepoUiAction.FetchRepoList -> fetchRepo(it.params)
            }
        }
    }

    private fun fetchRepo(params : RepoListApiUseCase.Params)
    {
        execute {
            repoListApiUseCase.execute(params).collect {result->
                when(result) {
                    is ApiResult.Success ->  _uiStateEvent.send(RepoUiStateEvent.FetchDataApiSuccess(result.data))
                    is ApiResult.Loading -> _uiState.value = RepoUiState.Loading(result.loading)
                    is ApiResult.Error -> _uiStateEvent.send(RepoUiStateEvent.FetchDataApiError(result.message))
                    is ApiResult.NetworkError -> _uiStateEvent.send(RepoUiStateEvent.NetworkError(result.message))
                }
            }
        }
    }
}

sealed class RepoUiState<out R> {
    data class Loading(val loading: Boolean) : RepoUiState<Loading>()
}

sealed class RepoUiStateEvent<out R>{
    data class FetchDataApiSuccess(val educationLevels : List<RepoApiResponseItemEntity>) : RepoUiStateEvent<FetchDataApiSuccess>()
    data class FetchDataApiError(val message : String) : RepoUiStateEvent<FetchDataApiError>()
    data class NetworkError(val message : String) : RepoUiStateEvent<NetworkError>()
}

sealed class RepoUiAction{
    data class FetchRepoList(val params : RepoListApiUseCase.Params) : RepoUiAction()
}