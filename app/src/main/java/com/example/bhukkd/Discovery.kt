package com.example.bhukkd

import android.support.design.widget.TabLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

import com.example.bhukkd.MenuItemObj
import com.example.bhukkd.Cart

import kotlinx.android.synthetic.main.activity_discovery.*
import kotlinx.android.synthetic.main.fragment_discovery.view.*
import kotlinx.android.synthetic.main.menu_item.view.*
import java.util.ArrayList

class Discovery : AppCompatActivity() {

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discovery)

        setSupportActionBar(toolbar)
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_discovery, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1)
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
           var items : Array<MenuItemObj> = arrayOf(MenuItemObj("Sweet Corn Pizza", 80, 0), MenuItemObj("sdfkja", 90, 0))


            val rootView = inflater.inflate(R.layout.fragment_discovery, container, false)

            val ll :LinearLayout = rootView.findViewById<LinearLayout>(R.id.item_list)
            var cart: MutableList<MenuItemObj> = ArrayList<MenuItemObj>();
            ll.removeAllViews();
            for (itemObj in items)
            {
                var itemView : View = LayoutInflater.from(activity).inflate(R.layout.menu_item, null,true)
                var item_name : TextView = itemView.findViewById<TextView>(R.id.item_name)
                item_name.text = itemObj.itemName
                var item_price : TextView = itemView.findViewById<TextView>(R.id.item_price)
                item_price.text = itemObj.itemPrice.toString()
                var addBtn :Button = itemView.findViewById<Button>(R.id.additem)
                var qty = 0;
                addBtn.setOnClickListener{
                    var ckItem: MenuItemObj;
                    ckItem = MenuItemObj("${itemObj.itemName}", itemObj.itemPrice, qty++)
                    cart.add(ckItem);
                    addBtn.text = qty.toString()
                }
                Log.e("cart",cart.toString());
                ll.addView(itemView)
            }

            return rootView
        }

        companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private val ARG_SECTION_NUMBER = "section_number"

            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }
}
