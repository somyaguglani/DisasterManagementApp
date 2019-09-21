package somya.com.nasa;

import android.os.Parcel;
import android.os.Parcelable;

public class Information implements Parcelable {
    String info;

    public Information(String info) {
        this.info = info;
    }

    protected Information(Parcel in) {
        info = in.readString();
    }

    public static final Creator<Information> CREATOR = new Creator<Information>() {
        @Override
        public Information createFromParcel(Parcel in) {
            return new Information(in);
        }

        @Override
        public Information[] newArray(int size) {
            return new Information[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(info);
    }
}
