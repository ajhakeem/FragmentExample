package projects.jaseem.fragmentexample.ui

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import projects.jaseem.fragmentexample.R
import projects.jaseem.fragmentexample.ui.listfragment.ListFragment
import projects.jaseem.fragmentexample.ui.main.MainFragment

class MainActivity : DaggerAppCompatActivity(), ActivityListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }

    override fun onNextClicked() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ListFragment.newInstance())
            .commitNow()
    }
}
