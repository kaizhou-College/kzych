package com.kz.po;

public class Introduce {
    private Long id;

    private String detail;

    private Video video;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    
    public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}