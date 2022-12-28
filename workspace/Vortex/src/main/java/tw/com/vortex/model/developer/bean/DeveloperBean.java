package tw.com.vortex.model.developer.bean;

import java.io.Serializable;

public class DeveloperBean implements Serializable  {
	private static final long serialVersionUID = 1L;
	private int developerId;
	private String name;
	private String url;

	public int getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
