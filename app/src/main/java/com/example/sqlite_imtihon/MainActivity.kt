package com.example.sqlite_imtihon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.sqlite_imtihon.Adapter.MyUserAdapter
import com.example.sqlite_imtihon.databinding.ActivityMainBinding
import com.example.sqlite_imtihon.databinding.ItemDialogBinding
import com.example.sqlite_imtihon.db.MyDbHelper
import com.example.sqlite_imtihon.models.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var myUserAdapter: MyUserAdapter
    lateinit var list: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDbHelper= MyDbHelper(binding.root.context)
        myUserAdapter=MyUserAdapter(myDbHelper.getAddUser())
        binding.rv.adapter=myUserAdapter

        binding.apply {
            add.setOnClickListener {
                val dialog= AlertDialog.Builder(binding.root.context).create()
                val itemDialogBinding=ItemDialogBinding.inflate(layoutInflater)
                dialog.setView(itemDialogBinding.root)
                Toast.makeText(this@MainActivity, "Save 1", Toast.LENGTH_SHORT).show()
                itemDialogBinding.root.setOnClickListener {
                    val user=User(
                        itemDialogBinding.edtName.text.toString().trim(),
                    )
                    Toast.makeText(this@MainActivity, "$user", Toast.LENGTH_SHORT).show()
                    myDbHelper.addUser(user)
                    dialog.cancel()
                }

                itemDialogBinding.btnCanel.setOnClickListener {
                    dialog.cancel()
                }

                dialog.show()
            }
        }
        }
    }
