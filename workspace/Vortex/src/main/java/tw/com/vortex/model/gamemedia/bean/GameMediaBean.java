package tw.com.vortex.model.gamemedia.bean;

import java.io.Serializable;

public class GameMediaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int mediaId;
	private String resource;
	private String resourceType;
	private int gameId;

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

}
