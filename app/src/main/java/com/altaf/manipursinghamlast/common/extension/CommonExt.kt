package com.altaf.manipursinghamlast.common.extension

import androidx.annotation.AnimRes
import androidx.annotation.AnimatorRes
import androidx.navigation.NavController
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.altaf.manipursinghamlast.R
import org.json.JSONArray


/**Convert simple object to String with Gson*/
inline fun <reified T : Any> T.toSimpleJson() : String =  Gson().toJson(this, T::class.java)

/**Convert String Json to Object*/
inline fun <reified T : Any> String.fromJsonToObject() : T =  Gson().fromJson(this ,  T::class.java)

/**Convert String List Json to Object*/
inline fun <reified T : Any> String.fromJsonToObjectList() : MutableList <T> =  when( this.isNotEmpty()){
    true -> Gson().fromJson(this, object : TypeToken<MutableList<T>>() {}.type)
    false -> mutableListOf()
}

fun JSONArray.toMutableList(): MutableList<Any> = MutableList(length(), this::get)

/**
 * Navigate with default slide animation
 */
fun NavController.navigateWithAnimation(
    destinationId: Int,
    args: android.os.Bundle? = null,
    @AnimatorRes @AnimRes enterAnim: Int = R.anim.slide_in_right,
    @AnimatorRes @AnimRes exitAnim: Int = R.anim.slide_out_left,
    @AnimatorRes @AnimRes popEnterAnim: Int = R.anim.slide_in_left,
    @AnimatorRes @AnimRes popExitAnim: Int = R.anim.slide_out_right
) {
    val options = androidx.navigation.NavOptions.Builder()
        .setEnterAnim(enterAnim)
        .setExitAnim(exitAnim)
        .setPopEnterAnim(popEnterAnim)
        .setPopExitAnim(popExitAnim)
        .build()
    
    try {
        navigate(destinationId, args, options)
    } catch (e: Exception) {
        // Handle navigation exception
        e.printStackTrace()
    }
}
