package com.huigwon.study0429.dao;

import java.util.ArrayList;

import com.huigwon.study0429.dto.ContentDto;

public interface IDao {
	
	public ArrayList<ContentDto> listDao();
	public void writeDao(String mwriter, String mcontent);
	public void deleteDao(String mid);
	public ArrayList<ContentDto> mlistDao(String mid);
	public void modifyDao(String mid, String mwriter, String mcontent);
}
