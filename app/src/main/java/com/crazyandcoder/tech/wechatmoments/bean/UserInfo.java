package com.crazyandcoder.tech.wechatmoments.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * @ClassName: UserInfo
 * @Description: java类作用描述
 * @Author: crazyandcoder
 * @email: lijiwork@sina.com
 * @CreateDate: 2020/3/10 4:44 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/10 4:44 PM
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class UserInfo implements Parcelable {

    /**
     * {
     * "profile-image": "http://img2.findthebest.com/sites/default/files/688/media/images/Mingle_159902_i0.png",
     * "avatar": "http://info.thoughtworks.com/rs/thoughtworks2/images/glyph_badge.png",
     * "nick": "John Smith",
     * "username": "jsmith"
     * }
     */
    private String profileImage;
    private String avatar;
    private String nick;
    private String username;

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "profileImage='" + profileImage + '\'' +
                ", avatar='" + avatar + '\'' +
                ", nick='" + nick + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.profileImage);
        dest.writeString(this.avatar);
        dest.writeString(this.nick);
        dest.writeString(this.username);
    }

    public UserInfo() {
    }

    protected UserInfo(Parcel in) {
        this.profileImage = in.readString();
        this.avatar = in.readString();
        this.nick = in.readString();
        this.username = in.readString();
    }

    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
}
