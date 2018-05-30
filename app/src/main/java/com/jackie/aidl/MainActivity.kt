package com.jackie.aidl

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var aidl: FirstAIDL? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindService(
                Intent(),
                object : ServiceConnection{
                    override fun onServiceDisconnected(name: ComponentName?) {
                        aidl = null
                    }

                    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                        aidl = FirstAIDL.Stub.asInterface(service)
                    }
                },
                0
        )
    }
}
