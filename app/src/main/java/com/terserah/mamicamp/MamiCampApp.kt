package com.terserah.mamicamp

import android.app.Application
import android.util.Log
import timber.log.Timber

class MamiCampApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(object : Timber.DebugTree(){
            override fun createStackElementTag(element: StackTraceElement): String? {
                //return super.createStackElementTag(element)

                /*Log.i(element.className, "This is my message, there are many like one but this one is mine" +
                        " (" + element.fileName + ":" + element.lineNumber + ")")*/

                //return String.format("C:%s:%s", super.createStackElementTag(element), element.lineNumber)

                return "(${element.fileName}:${element.lineNumber})"
            }
        })
    }
}