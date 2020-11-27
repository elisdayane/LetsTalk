package br.com.elis.letstalk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //troca de tela
        Handler(Looper.getMainLooper()).postDelayed({
            //criando a intencao (intent) de trocar de tela
            val mIntent = Intent(this, MainActivity::class.java)

            //iniciar a proxima tela
            startActivity(mIntent)

            //finalizando a tela splash
            finish()

        },2500)
    }
}