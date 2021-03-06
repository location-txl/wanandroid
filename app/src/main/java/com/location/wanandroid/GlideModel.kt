package com.location.wanandroid

import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

/**
 *
 * @author tianxiaolong
 * time：2021/3/5 10:58 PM
 * description：
 */
@GlideModule
class GlideModel: AppGlideModule() {
    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}