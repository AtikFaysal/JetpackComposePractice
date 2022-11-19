package com.jetpack.compose

import com.jetpack.apientity.ProfileApiEntity
import com.jetpack.domain.apiusecase.ProfileApiUseCase
import com.jetpack.domain.base.ApiResult
import com.jetpack.domain.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileApiUseCase: ProfileApiUseCase,
) : BaseViewModel(){

    val action: (ProfileUiAction) -> Unit

    private val _uiState = MutableStateFlow<ProfileUiState<Any>>(ProfileUiState.Loading(false))
    val uiState get() = _uiState

    private val _uiStateEvent = Channel<ProfileUiStateEvent<Any>>()
    val uiStateEvent get() = _uiStateEvent.receiveAsFlow()

    init {
        action = {
            when(it){
                is ProfileUiAction.FetchRepoList -> fetchProfile(it.params)
            }
        }
    }

    private fun fetchProfile(params : ProfileApiUseCase.Params)
    {
        execute {
            profileApiUseCase.execute(params).collect {result->
                when(result) {
                    is ApiResult.Success ->  _uiStateEvent.send(ProfileUiStateEvent.FetchDataApiSuccess(result.data))
                    is ApiResult.Loading -> _uiState.value = ProfileUiState.Loading(result.loading)
                    is ApiResult.Error -> _uiStateEvent.send(ProfileUiStateEvent.FetchDataApiError(result.message))
                    is ApiResult.NetworkError -> _uiStateEvent.send(ProfileUiStateEvent.NetworkError(result.message))
                }
            }
        }
    }
}

sealed class ProfileUiState<out R> {
    data class Loading(val loading: Boolean) : ProfileUiState<Loading>()
}

sealed class ProfileUiStateEvent<out R>{
    data class FetchDataApiSuccess(val educationLevels : ProfileApiEntity) : ProfileUiStateEvent<FetchDataApiSuccess>()
    data class FetchDataApiError(val message : String) : ProfileUiStateEvent<FetchDataApiError>()
    data class NetworkError(val message : String) : ProfileUiStateEvent<NetworkError>()
}

sealed class ProfileUiAction{
    data class FetchRepoList(val params : ProfileApiUseCase.Params) : ProfileUiAction()
}