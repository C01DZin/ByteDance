package com.bytedance.android.lesson.restapi.restapi.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Xavier.S
 * @date 2019.01.15 17:18
 */
public class Joke {

    /**
     * type : success
     * value : {"id":412,"joke":"Chuck Norris knows the last digit of pi.","categories":["nerdy"]}
     */

    @SerializedName("type") private String type;
    @SerializedName("value") private Value value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public static class Value {
        /**
         * id : 412
         * joke : Chuck Norris knows the last digit of pi.
         * categories : ["nerdy"]
         */

        @SerializedName("id") private int id;
        @SerializedName("joke") private String joke;
        @SerializedName("categories") private List<String> categories;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getJoke() {
            return joke;
        }

        public void setJoke(String joke) {
            this.joke = joke;
        }

        public List<String> getCategories() {
            return categories;
        }

        public void setCategories(List<String> categories) {
            this.categories = categories;
        }

        @Override public String toString() {
            return "Value{" +
                    "id=" + id +
                    ", joke='" + joke + '\'' +
                    ", categories=" + categories +
                    '}';
        }
    }

    @Override public String toString() {
        return "Joke{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
