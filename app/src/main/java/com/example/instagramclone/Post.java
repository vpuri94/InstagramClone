package com.example.instagramclone;

import android.text.format.DateUtils;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import org.parceler.Parcel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@ParseClassName("Post")
@Parcel(analyze={Post.class})
public class Post extends ParseObject {

    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_USER = "user";
    public static final String KEY_CREATED = "createdAt";

    public String getDescription(){
        return getString(KEY_DESCRIPTION);
    }

    public void setDescription(String description){
        put(KEY_DESCRIPTION, description);
    }

    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile) {
        put(KEY_IMAGE, parseFile);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date =  getCreatedAt();
        String dateTime = dateFormat.format(date);
        // Converts the format above into "XX minutes or XX days ago
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            long time = dateFormat.parse(dateTime).getTime();
            long now = System.currentTimeMillis();
            CharSequence ago =
                    DateUtils.getRelativeTimeSpanString(time, now, DateUtils.MINUTE_IN_MILLIS);
            return (String)ago;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setUser(ParseUser user) {
        put(KEY_USER, user);
    }

}
