package pl.agnieszkaderen.sweetestdog.model;

import java.sql.Timestamp;

public class Score {
	
	private long id;
	private long photoId;
	private long userId;
	private Timestamp date;
	
	public Score() {}

	public Score(Score score) {
		this.id = score.id;
		this.photoId = score.photoId;
		this.userId = score.userId;
		this.date = new Timestamp(score.date.getTime());;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(long photoId) {
		this.photoId = photoId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", photoId=" + photoId + ", userId=" + userId + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (photoId ^ (photoId >>> 32));
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (photoId != other.photoId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}




		

}
