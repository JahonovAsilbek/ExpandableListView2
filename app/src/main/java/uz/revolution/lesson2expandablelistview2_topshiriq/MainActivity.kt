package uz.revolution.lesson2expandablelistview2_topshiriq

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import uz.revolution.lesson2expandablelistview2_topshiriq.models.ChildActivity
import uz.revolution.lesson2expandablelistview2_topshiriq.models.MyModel

class MainActivity : AppCompatActivity() {

    lateinit var titleList: ArrayList<String>
    lateinit var map: HashMap<String, ArrayList<MyModel>>
    lateinit var list: ArrayList<MyModel>
    lateinit var adapter: ExpandableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        adapter = ExpandableAdapter(titleList, map)
        expandable_list_view.setAdapter(adapter)

        adapter.setOnChildItemClickListener(object : ExpandableAdapter.OnChildItemClickListener {
            override fun onClick(name: String, info: String) {

                val intent = Intent(this@MainActivity, ChildActivity::class.java)
                intent.putExtra("name", name)
                startActivity(intent)
            }


        })

    }

    private fun loadData() {
        map = HashMap()

        val mobileList = ArrayList<MyModel>()
        mobileList.add(MyModel("Mi", "there should have been information here"))
        mobileList.add(MyModel("RealMe", "there should have been information here"))
        mobileList.add(MyModel("Samsung", "there should have been information here"))
        mobileList.add(MyModel("Infinix", "there should have been information here"))
        mobileList.add(MyModel("Oppo", "there should have been information here"))
        mobileList.add(MyModel("iPhone", "there should have been information here"))
        mobileList.add(MyModel("Honor", "there should have been information here"))
        map.put("Mobiles", mobileList)

        val laptopList = ArrayList<MyModel>()
        laptopList.add(MyModel("Dell", "there should have been information here"))
        laptopList.add(MyModel("Mac", "there should have been information here"))
        laptopList.add(MyModel("HP", "there should have been information here"))
        laptopList.add(MyModel("ASUS", "there should have been information here"))
        map["Laptops"] = laptopList

        val accessoriesList = ArrayList<MyModel>()
        accessoriesList.add(MyModel("Pendrive", "there should have been information here"))
        accessoriesList.add(MyModel("Bag", "there should have been information here"))
        accessoriesList.add(MyModel("Mouse", "there should have been information here"))
        accessoriesList.add(MyModel("Keyboard", "there should have been information here"))
        map["Computer Accessories"] = accessoriesList

        val homeIntertaintmentList = ArrayList<MyModel>()
        homeIntertaintmentList.add(MyModel("Home Audio Speakers", "there should have been information here"))
        homeIntertaintmentList.add(MyModel("Home Theatres", "there should have been information here"))
        homeIntertaintmentList.add(MyModel("Bluetooth Speakers", "there should have been information here"))
        homeIntertaintmentList.add(MyModel("DTH Set Top Box", "there should have been information here"))
        map["Home Intertainment"] = homeIntertaintmentList

        val tvsByBrand = ArrayList<MyModel>()
        tvsByBrand.add(MyModel("LG", "there should have been information here"))
        tvsByBrand.add(MyModel("Samsung", "there should have been information here"))
        tvsByBrand.add(MyModel("Artel", "there should have been information here"))
        tvsByBrand.add(MyModel("Avalon", "there should have been information here"))
        tvsByBrand.add(MyModel("Toshiba", "there should have been information here"))
        map["TVs By Brand"] = tvsByBrand

        val kitchenAppliances = ArrayList<MyModel>()
        kitchenAppliances.add(MyModel("Oven", "there should have been information here"))
        kitchenAppliances.add(MyModel("Kitchen Furniture", "there should have been information here"))
        kitchenAppliances.add(MyModel("Blender", "there should have been information here"))
        kitchenAppliances.add(MyModel("Meat Grinder", "there should have been information here"))
        kitchenAppliances.add(MyModel("Teapot", "there should have been information here"))
        map["Kitchen Applianes"] = kitchenAppliances

        titleList = ArrayList()
        titleList.add("Mobiles")
        titleList.add("Laptops")
        titleList.add("Computer Accessories")
        titleList.add("Home Intertainment")
        titleList.add("TVs By Brand")
        titleList.add("Kitchen Applianes")


    }
}