package com.jetpack.common.extfun

import android.app.Activity
import android.content.Intent
import android.os.Bundle

/**
 * ...navigate to next activity
 * @param isPrevActivityFinished is true then finished current activity
 */
fun Activity.navigateToNextActivity(className : String,isPrevActivityFinished : Boolean, bundle : Bundle?){
    val intent = Intent().setClassName(this,className)
    bundle?.let {
        intent.putExtras(it)
    }
    intent.apply {
        startActivity(this)
    }

    if(isPrevActivityFinished)
        finish()
}