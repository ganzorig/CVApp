package com.miu.curriculumvitae.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.marginBottom
import com.miu.curriculumvitae.R
import com.miu.curriculumvitae.common.Education
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.item.view.*
import kotlinx.android.synthetic.main.item_small.view.*


class AboutFragment : Fragment() {
    var ed1 = Education("Master of Science and Technology", 2021, "MIU")
    var ed2 = Education("Bachelor of Technology", 2010, "CSMS")
    val educations = arrayOf(ed1, ed2)

    var weakneses = arrayOf("Kind", "Greedy", "Funny", "Sad")
    var strengths = arrayOf("Kind", "Greedy", "Funny", "Sad")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        val eduParent = view.findViewById<LinearLayout>(R.id.educations)
        val weakParent = view.findViewById<LinearLayout>(R.id.weaknesses)
        val strParent = view.findViewById<LinearLayout>(R.id.strengths)

        for (edu in educations) {
            val item = inflater.inflate(R.layout.item, container, false)
            item.title.text= edu.title
            item.place.text= edu.school
            item.year.text= edu.year.toString()
            eduParent.addView(item)
        }

        for (weak in weakneses) {
            val item = inflater.inflate(R.layout.item_small, container, false)
            item.item_txtView.text = weak
            item.item_txtView.setBackgroundResource(R.drawable.item_back_green)
            weakParent.addView(item)
        }

        for (str in strengths) {
            val item = inflater.inflate(R.layout.item_small, container, false)
            item.item_txtView.text = str
            strParent.addView(item)
        }

        return view
    }
}
