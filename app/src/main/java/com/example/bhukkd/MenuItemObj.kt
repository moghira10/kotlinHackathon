package com.example.bhukkd

import android.os.Parcel
import android.os.Parcelable

public class MenuItemObj    (var itemName: String, var itemPrice: Int, var quantity: Int) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(itemName)
        parcel.writeInt(itemPrice)
        parcel.writeInt(quantity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MenuItemObj> {
        override fun createFromParcel(parcel: Parcel): MenuItemObj {
            return MenuItemObj(parcel)
        }

        override fun newArray(size: Int): Array<MenuItemObj?> {
            return arrayOfNulls(size)
        }
    }

}