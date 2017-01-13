/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.app.usage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.UserHandle;

/**
 * Shared/external storage statistics for a {@link UserHandle} on a single
 * storage volume.
 *
 * @see StorageStatsManager
 */
public final class ExternalStorageStats implements Parcelable {
    /** {@hide} */ public long totalBytes;
    /** {@hide} */ public long audioBytes;
    /** {@hide} */ public long videoBytes;
    /** {@hide} */ public long imageBytes;

    /**
     * Return the total bytes used by all files in the shared/external storage
     * hosted on this volume.
     */
    public long getTotalBytes() {
        return totalBytes;
    }

    /**
     * Return the total bytes used by audio files in the shared/external storage
     * hosted on this volume.
     */
    public long getAudioBytes() {
        return audioBytes;
    }

    /**
     * Return the total bytes used by video files in the shared/external storage
     * hosted on this volume.
     */
    public long getVideoBytes() {
        return videoBytes;
    }

    /**
     * Return the total bytes used by image files in the shared/external storage
     * hosted on this volume.
     */
    public long getImageBytes() {
        return imageBytes;
    }

    /** {@hide} */
    public ExternalStorageStats() {
    }

    /** {@hide} */
    public ExternalStorageStats(Parcel in) {
        this.totalBytes = in.readLong();
        this.audioBytes = in.readLong();
        this.videoBytes = in.readLong();
        this.imageBytes = in.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(totalBytes);
        dest.writeLong(audioBytes);
        dest.writeLong(videoBytes);
        dest.writeLong(imageBytes);
    }

    public static final Creator<ExternalStorageStats> CREATOR = new Creator<ExternalStorageStats>() {
        @Override
        public ExternalStorageStats createFromParcel(Parcel in) {
            return new ExternalStorageStats(in);
        }

        @Override
        public ExternalStorageStats[] newArray(int size) {
            return new ExternalStorageStats[size];
        }
    };
}
