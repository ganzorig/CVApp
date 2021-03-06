package com.miu.curriculumvitae

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.miu.curriculumvitae.common.Person
import kotlinx.android.synthetic.main.activity_login.*
import com.miu.curriculumvitae.common.*

class LoginActivity : AppCompatActivity() {
    val KEY = "PERSON"
    val PREF = "CVPREF"
    var users = ArrayList<Person>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        createPerson()

        val prefs = getSharedPreferences(PREF, MODE_PRIVATE)

        if (prefs.getBoolean("auth", false)) {
            val email = prefs.getString("email", "")
            if (email != null) {
                val foundUser = findUserByEmail(email)
                if(foundUser != null) {
                    startMainActivity(foundUser)
                }
            }
        }

        login.setOnClickListener {
            val inputEmail = et_email.text.toString()
            if (isValidated(inputEmail, et_password.text.toString())) {
                val editor = prefs.edit()

                editor.putBoolean("auth", true)
                editor.putString("email", inputEmail)
                editor.apply()

                val foundUser = findUserByEmail(inputEmail)
                if(foundUser != null) {
                    startMainActivity(foundUser)
                }


            } else {
                Toast.makeText(applicationContext, "Wrong credential", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun startMainActivity(person: Person) {
        var mainIntent = Intent(applicationContext, MainActivity::class.java)

        mainIntent.putExtra(KEY, person)
        startActivity(mainIntent)
    }

    private fun isValidated(email: String, password: String): Boolean {
        for (user in users) {
            if (user.contact.email == email && user.password == password) {
                return true
            }
        }
        return false
    }

    private fun findUserByEmail(email: String): Person? {
        for (user in users) {
            if (user.contact.email == email) {
                println(user.contact.email)
                return user
            }
        }
        return null
    }

    fun createPerson() {
        //---------------------------------Contact---------------------------------//
        var contact1: Contact = Contact("99001122", "gbayarsaikhan@miu.edu.mn","g4nzorig","gzo_326","https://github.com/ganzorig","g4nzo")
        var contact3: Contact = Contact("99112323", "eganbaatar@miu.edu.mn","enkhee.hana10","enkhee21571517","https://github.com/egy10", "enkhuul88")
        var contact2: Contact = Contact("99090099", "oganbold@miu.edu.mn","oyunbold.ganbold","GanboldG","https://github.com/goyunbold","oyunboldg")
        var contact4: Contact = Contact("93090002", "notgonbayar@miu.edu.mn","norovdorjo","norovdoo","https://github.com/norovoo","norovdorjo")

        //---------------------------------Contact end---------------------------------//
        //---------------------------------Education---------------------------------//
        var education1: Education = Education("Bachelor of Computer Science", "2007-2011","CSMS of Mongolia")
        var education1_1: Education = Education("Master of Computer Science", "2021-2023", "MIU")
        var education2: Education = Education("Bachelor of Computer Networking", "2004-2009","CSMS of Mongolia")
        var education2_1: Education = Education("Master of Computer Science", "2021-2023", "MIU")
        var education3: Education = Education("Bachelor of Computer Science", "2015-2019","National University of Mongolia")
        var education3_1: Education = Education("Master of Computer Science", "2021-2023", "MIU")
        var education4: Education = Education("Bachelor of Computer Science", "2007-2011","National University of Mongolia")
        var education4_1: Education = Education("Master of Space Technology Applications", "2012-2014", "Beihang University")
        var education4_2: Education = Education("Master of Computer Science", "2021-2023", "MIU")
        //---------------------------------Education end---------------------------------//
        //---------------------------------Project---------------------------------//
        var project1: Project = Project("2007-2009","NMMG Android main app", "Android developer")
        var project1_1: Project = Project("2009-2010","ERXES Platform", "Front-End based stuff")
        var project2: Project = Project("2004-2006","Government organization network infrastructure", "Building and Fixing")
        var project2_1: Project = Project("2011-2014","Network monitoring System in ISPs", "Build monitoring section front end and backend")
        var project3: Project = Project("2015-2017","U-Point loyalty system", "Mobile developer(IoS and Android)")
        var project3_1: Project = Project("2017-2019","Jamuha platform", "Front-End related stuff")
        var project4: Project = Project("2015-2016","Police fine system", "Back-End developer and Database reporting admin")
        var project4_1: Project = Project("2017-2019","VAT promotion system", "Database & System Admin")
        //---------------------------------Project end---------------------------------//
        //---------------------------------Work---------------------------------//
        var work1: Work = Work("2011-2021", "NMMG","Senior Developer")
        var work2: Work = Work("2004-2006", "Ministry of Mining","Network Administrator")
        var work2_1: Work = Work("2006-2009", "AJAX ISP","Network Administrator")
        var work2_2: Work = Work("2009-2021", "Free Agent","Full Stack Developer")
        var work3: Work = Work("2015-2021", "Shine Mongol School","Software Developer")
        var work4: Work = Work("2011-2021", "EBarimt","DBA")
        //---------------------------------Work end---------------------------------//

        //---------------------------------Person1---------------------------------//
        var person1Strength: ArrayList<String> = arrayListOf("Confident", "Creative", "Dedicated", "Determined", "Decisive")
        var person1Weaknesses: ArrayList<String> = arrayListOf("Impatient", "Allows emotions to show", "Close-minded", "Perfectionist", "Likes to take risks")
        var person1Skills: ArrayList<String> = arrayListOf("Flexibility", "NodeJS", "ReactJS", "Angular", "MeteorJS", "VueJS")
        var person1:Person = Person(R.drawable.ava_ganzorig, "Ganzorig", "Bayarsaikhan", "miu123", "Front-End Developer", "I am over 8+ years of IT experience which includes 6+ years of Extensive experience as a Front End Developer and 3 years of Experience as a UI/UX Developer and 2 years of Experience as mobile application Developer.\n", "www.leetcode.com/gzo326", person1Strength, person1Weaknesses, person1Skills, arrayListOf(education1, education1_1),contact1, arrayListOf(project1,project1_1), arrayListOf(work1))

        //---------------------------------Person2---------------------------------//
        var person2Strength: ArrayList<String> = arrayListOf("Industrious", "Hopeful", "Honest", "Motivated", "Precise")
        var person2Weaknesses: ArrayList<String> = arrayListOf("Delegating tasks", "Critical of others", "Bossy", "Strict", "Strong willed")
        var person2Skills: ArrayList<String> = arrayListOf("JAVA", "Project Management", "Shell scripting", "Interest in Helping Others", "Curiosity")
        var person2:Person = Person(R.drawable.ava_oyunbold, "Oyunbold", "Ganbold", "miu123", "Full Stack Developer", "Network Engineer with 6+ years of experience in network design, escalation support, network administration, and systems administration. Skilled in delivering technical support, managing network operations, and maintaining enterprise-wide area networks across multi-platform and high uptime Data Center environments.", "www.leetcode.com/oyunbold", person2Strength, person2Weaknesses, person2Skills, arrayListOf(education2, education2_1),contact2, arrayListOf(project2,project2_1), arrayListOf(work2,work2_1,work2_2))

        //---------------------------------Person3---------------------------------//
        var person3Strength: ArrayList<String> = arrayListOf("Confident", "Creative", "Dedicated", "Determined", "Decisive")
        var person3Weaknesses: ArrayList<String> = arrayListOf("Impatient", "Allows emotions to show", "Close-minded", "Perfectionist", "Likes to take risks")
        var person3Skills: ArrayList<String> = arrayListOf("Kotlin", "Java", "Java Script", "Mongo DB", "Mobile programming")
        var person3:Person = Person(R.drawable.ava_enkhee, "Enkhtsetseg", "Ganbaatar", "miu123", "MobileDeveloper", "Senior Mobile Developer with over 8+ years of IT experience in Analysis, Design, and Development of various Mobile Application development for iPhone (Xcode, Objective C, and Cocoa framework) and Android. Extensive iPhone and iPod Touch application development experience. ", "www.leetcode.com/egy", person3Strength, person3Weaknesses, person3Skills, arrayListOf(education3, education3_1),contact3, arrayListOf(project3,project3_1), arrayListOf(work3))

        //---------------------------------Person4---------------------------------//
        var person4Strength: ArrayList<String> = arrayListOf("Confident", "Creative", "Dedicated", "Determined", "Decisive")
        var person4Weaknesses: ArrayList<String> = arrayListOf("Impatient", "Allows emotions to show", "Close-minded", "Perfectionist", "Likes to take risks")
        var person4Skills: ArrayList<String> = arrayListOf("Oracle", "Oracle GG, DG", "MSSQL Server", "MySQL", "Docker","Java")
        var person4:Person = Person(R.drawable.ava_noro, "Norovdorj", "Otgonbayar", "miu123", "Back-End Developer", "Data Scientist with 8+ years of experience executing data-driven solutions to increase efficiency, accuracy, and utility of internal data processing. Experienced at creating data regression models, using predictive data modeling, and analyzing data mining algorithms to deliver insights and implement action-oriented solutions to complex business problems.", "www.leetcode.com/norovdorj", person4Strength, person4Weaknesses, person4Skills, arrayListOf(education4, education4_1, education4_2),contact4, arrayListOf(project4,project4_1), arrayListOf(work4))

        users.add(person1)
        users.add(person2)
        users.add(person3)
        users.add(person4)
    }
}