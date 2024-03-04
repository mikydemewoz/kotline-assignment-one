package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var chemical_list: MutableList<String> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val add: Button = findViewById(R.id.add_btn)
        val water_resource_name: EditText = findViewById(R.id.water_resource_name)
        val location: EditText = findViewById(R.id.location)
        val type: EditText = findViewById(R.id.type)
        val tableLayout: TableLayout = findViewById(R.id.tableLayout)

        val add_buttonListener = View.OnClickListener {
            val water_resource_name_str: String =water_resource_name.text.toString().trim()
            val location_str: String =location.text.toString().trim()
            val type_str: String =type.text.toString().trim()
            if (water_resource_name_str.equals("")){
                Toast.makeText(this, "Water Resource Name is empty", Toast.LENGTH_SHORT).show()
            }else if(location_str.equals("")){
                Toast.makeText(this, "Location is empty", Toast.LENGTH_SHORT).show()
            }else if(type_str.equals("")){
                Toast.makeText(this, "Type is empty", Toast.LENGTH_SHORT).show()
            }else{
                add_to_list(water_resource_name_str, location_str, type_str,tableLayout)
            }

        }

        add.setOnClickListener(add_buttonListener)
        tableLayout.requestLayout()

    }

    private fun add_to_list(
        water_resource_name: String,
        location_str: String,
        type_str: String,
        tableLayout: TableLayout
    ) {
        val water_resource_name_tx: TextView = TextView(this)
        val location_tx: TextView = TextView(this)
        val type_tx: TextView = TextView(this)
        val layoutParams1 = TableRow.LayoutParams(0, WRAP_CONTENT, 1f)
        val layoutParams2 = TableRow.LayoutParams(0, WRAP_CONTENT, 0.5f)

        water_resource_name_tx.text = water_resource_name
        water_resource_name_tx.layoutParams = layoutParams1
        water_resource_name_tx.gravity = android.view.Gravity.CENTER
        water_resource_name_tx.setBackgroundResource(R.drawable.column_divider)
        location_tx.text = location_str
        location_tx.layoutParams = layoutParams2
        location_tx.gravity = android.view.Gravity.CENTER
        location_tx.setBackgroundResource(R.drawable.column_divider)
        type_tx.text = type_str
        type_tx.layoutParams = layoutParams2
        type_tx.gravity = android.view.Gravity.CENTER
        type_tx.setBackgroundResource(R.drawable.column_divider)


        val tableRow: TableRow = TableRow(this)

        tableRow.addView(water_resource_name_tx)
        tableRow.addView(location_tx)
        tableRow.addView(type_tx)

        tableLayout.addView(tableRow)
    }
}