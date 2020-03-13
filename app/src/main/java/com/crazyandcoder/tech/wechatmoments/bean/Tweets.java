package com.crazyandcoder.tech.wechatmoments.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Tweets
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/11 9:24 AM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/11 9:24 AM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Tweets implements Parcelable {

    /**
     * content : 沙发！
     * images : [{"url":"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRDy7HZaHxn15wWj6pXE4uMKAqHTC_uBgBlIzeeQSj2QaGgUzUmHg"},{"url":"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTlJRALAf-76JPOLohBKzBg8Ab4Q5pWeQhF5igSfBflE_UYbqu7"},{"url":"http://i.ytimg.com/vi/rGWI7mjmnNk/hqdefault.jpg"}]
     * sender : {"username":"jport","nick":"Joe Portman","avatar":"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRJm8UXZ0mYtjv1a48RKkFkdyd4kOWLJB0o_l7GuTS8-q8VF64w"}
     * comments : [{"content":"Good.","sender":{"username":"outman","nick":"Super hero","avatar":"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRJm8UXZ0mYtjv1a48RKkFkdyd4kOWLJB0o_l7GuTS8-q8VF64w"}},{"content":"Like it too","sender":{"username":"inman","nick":"Doggy Over","avatar":"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRJm8UXZ0mYtjv1a48RKkFkdyd4kOWLJB0o_l7GuTS8-q8VF64w"}}]
     * error : losted
     * unknown error : STARCRAFT2
     */

    private String content;
    private Sender sender;
    private String error;
    private List<Images> images;
    private List<Comments> comments;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public static class Sender {
        /**
         * username : jport
         * nick : Joe Portman
         * avatar : https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRJm8UXZ0mYtjv1a48RKkFkdyd4kOWLJB0o_l7GuTS8-q8VF64w
         */

        private String username;
        private String nick;
        private String avatar;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }

    public static class Images {
        /**
         * url : https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRDy7HZaHxn15wWj6pXE4uMKAqHTC_uBgBlIzeeQSj2QaGgUzUmHg
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Comments {
        /**
         * content : Good.
         * sender : {"username":"outman","nick":"Super hero","avatar":"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRJm8UXZ0mYtjv1a48RKkFkdyd4kOWLJB0o_l7GuTS8-q8VF64w"}
         */

        private String content;
        private Sender sender;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Sender getSender() {
            return sender;
        }

        public void setSender(Sender sender) {
            this.sender = sender;
        }

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.content);
        dest.writeParcelable((Parcelable) this.sender, flags);
        dest.writeString(this.error);
        dest.writeList(this.images);
        dest.writeList(this.comments);
    }

    public Tweets() {
    }

    protected Tweets(Parcel in) {
        this.content = in.readString();
        this.sender = in.readParcelable(Sender.class.getClassLoader());
        this.error = in.readString();
        this.images = new ArrayList<Images>();
        in.readList(this.images, Images.class.getClassLoader());
        this.comments = new ArrayList<Comments>();
        in.readList(this.comments, Comments.class.getClassLoader());
    }

    public static final Parcelable.Creator<Tweets> CREATOR = new Parcelable.Creator<Tweets>() {
        @Override
        public Tweets createFromParcel(Parcel source) {
            return new Tweets(source);
        }

        @Override
        public Tweets[] newArray(int size) {
            return new Tweets[size];
        }
    };

    @Override
    public String toString() {
        return "Tweets{" +
                "content='" + content + '\'' +
                ", sender=" + sender +
                ", error='" + error + '\'' +
                ", images=" + images +
                ", comments=" + comments +
                '}';
    }
}

