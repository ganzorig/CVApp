package com.miu.curriculumvitae.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.miu.curriculumvitae.R
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("Hellooooo")
        var view = inflater.inflate(R.layout.fragment_contact, container, false)
        var facebook = view.findViewById<LinearLayout>(R.id.facebook)
        facebook.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                println("Image FB click")

                try {
                    var intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("fb://profile/enkhee.hana10")
                    );
                    startActivity(intent);
                } catch (e: Exception) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://www.facebook.com/enkhee.hana10")
                        )
                    );
                }
            }
        })
        // Inflate the layout for this fragment
        return view
    }

}
