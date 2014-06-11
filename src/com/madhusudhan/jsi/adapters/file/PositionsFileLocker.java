package com.madhusudhan.jsi.adapters.file;

import java.io.File;

import org.springframework.integration.file.FileLocker;

public class PositionsFileLocker implements FileLocker {

	public boolean lock(File fileToLock) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isLockable(File file) {
		// TODO Auto-generated method stub
		return false;
	}

	public void unlock(File fileToUnlock) {
		// TODO Auto-generated method stub

	}

}
