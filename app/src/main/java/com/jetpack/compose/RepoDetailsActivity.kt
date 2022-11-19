package com.jetpack.compose

import android.os.Bundle
import com.jetpack.common.base.BaseActivity
import com.jetpack.compose.databinding.LayoutRepoDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepoDetailsActivity : BaseActivity<LayoutRepoDetailsBinding>(){

    override fun viewBindingLayout(): LayoutRepoDetailsBinding = LayoutRepoDetailsBinding.inflate(layoutInflater)

    override fun initializeView(savedInstanceState: Bundle?) {

    }
}