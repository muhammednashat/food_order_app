package mnashat_dev.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import mnashat_dev.foodorder.authentecation.AuthenticationActivity
import mnashat_dev.foodorder.screens.MainActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        supportActionBar?.hide()

        Handler().postDelayed({
            startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
            finish()
        },3000)


    }

}