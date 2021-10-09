package com.miu.curriculumvitae

import android.content.Context
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val person = intent.getSerializableExtra("PERSON") as Person
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
                val pref = getSharedPreferences("CVPREF", Context.MODE_PRIVATE)
                val edit = pref.edit();
                edit.remove("auth")
                edit.remove("email")
                edit.apply()
                finish()
                return true;
            }
        }
        return super.onOptionsItemSelected(item)
    }
}