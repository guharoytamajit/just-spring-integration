package com.madhusudhan.jsi.adapters.file;

import java.util.ArrayList;
import java.util.List;

import org.springframework.integration.file.filters.FileListFilter;

import com.madhusudhan.jsi.domain.Position;

public class PositionsFilter implements FileListFilter<Position> {

	public List<Position> filterFiles(Position[] files) {
		List<Position> filteredList = new ArrayList<Position>();
		// implement your filtering logic here
		return filteredList;
	}

}
