package com.jetpack.compose

import android.os.Bundle
import com.jetpack.common.base.BaseActivity
import com.jetpack.compose.databinding.LayoutRepoListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepoListActivity : BaseActivity<LayoutRepoListBinding>() {

    override fun viewBindingLayout(): LayoutRepoListBinding = LayoutRepoListBinding.inflate(layoutInflater)

    override fun initializeView(savedInstanceState: Bundle?) {

    }
}