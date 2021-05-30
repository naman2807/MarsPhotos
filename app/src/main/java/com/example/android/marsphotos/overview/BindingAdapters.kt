package com.example.android.marsphotos.overview

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load


    @BindingAdapter("imageURL")
    fun bindImage(imgView : ImageView, imgSrc : String?){
        imgSrc?.let {
            val imgURI = imgSrc.toUri().buildUpon().scheme("https").build()
            imgView.load(imgURI)
        }
    }

/*
Binding Adapters are annotated methods used to create custom setters for custom properties of your view.

Usually when you set an attribute in your XML using the code: android:text="Sample Text".
The Android system automatically looks for a setter with the same name as the text attribute,
 which is set by the setText(String: text) method. The setText(String: text) method is a setter
 method for some views provided by the Android Framework. Similar behavior can be customized using
 the binding adapters; you can provide a custom attribute and custom logic that will be called by
 the Data binding library.

 <ImageView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:imageUrl="@{product.imageUrl}" />
If you do not add any further code, the system would look for a setImageUrl(String) method on
ImageView and not find it, throwing an error because this is a custom attribute not provided by
the framework. You have to create a way to implement and set the app:imageUrl attribute to the
ImageView. You will use Binding adapters (annotated methods) to do this.

The @BindingAdapter annotation takes the attribute name as its parameter.

In the bindImage method, the first method parameter is the type of the target View and the second is
the value being set to the attribute.

Inside the method, the Coil library loads the image off the UI thread and sets it into the ImageView.
 */