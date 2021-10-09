package com.miu.curriculumvitae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.miu.curriculumvitae.common.Person
import com.miu.curriculumvitae.fragments.AboutFragment
import com.miu.curriculumvitae.fragments.ContactFragment
import com.miu.curriculumvitae.fragments.HomeFragment
import com.miu.curriculumvitae.fragments.WorkFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val person = Person(R.drawable.male, "Ganzorig", "Bayarsaikhan", "gbayarsaikhan@miu.edu", "Front End Developer", "+1 669 281 6496", "Dedicated and efficient full stack developer with 6+ years experience in application layers, presentation layers, and databases.")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = person.firstName
        supportActionBar?.subtitle = person.profession

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment().newInstance(person), "Home")
        adapter.addFragment(AboutFragment(), "About")
        adapter.addFragment(WorkFragment(), "Work")
        adapter.addFragment(ContactFragment(), "Contact")

        viewPager.adapter = adapter

        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.home)
        tabs.getTabAt(1)!!.setIcon(R.drawable.about)
        tabs.getTabAt(2)!!.setIcon(R.drawable.work)
        tabs.getTabAt(3)!!.setIcon(R.drawable.contact)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.m1 -> {
                Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
                return true;
            }

            R.id.m3 -> {
                Toast.makeText(applicationContext, item.title, Toast.LENGTH_SHORT).show()
                return true;
            }
        }
        return super.onOptionsItemSelected(item)
    }
}