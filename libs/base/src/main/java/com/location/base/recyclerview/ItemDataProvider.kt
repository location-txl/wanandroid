package com.location.base.recyclerview

/**
 *
 * @author tianxiaolong
 * time：4/24/21 3:47 PM
 * description：
 */
internal interface ItemDataProvider<T> {
    fun  getItemData(position:Int):T
}