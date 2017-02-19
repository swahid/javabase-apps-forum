/**
 * 
 */
package org.javabase.apps.service;

import java.util.List;

import org.javabase.apps.entity.Thread;
import org.javabase.apps.mapper.ThreadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
@Service
public class ThreadServiceImpl implements ThreadService{
    
    @Autowired
    ThreadMapper threadMapper;

    @Override
    @Transactional(readOnly=true)
    public List<Thread> getAllThread() {
        return threadMapper.getAllThread();
    }

    @Override
    @Transactional
    public Boolean addThread(Thread Thread) {
        return threadMapper.addThread(Thread);
    }

    @Override
    @Transactional
    public Boolean updateThread(Thread Thread) {
        return threadMapper.updateThread(Thread);
    }

    @Override
    @Transactional
    public Boolean deleteThread(Thread contentId) {
        return threadMapper.deleteThread(contentId);
    }

    @Override
    @Transactional(readOnly=true)
    public Thread getThreadbyId(int id) {
        return threadMapper.getThreadbyId(id);
    }

}
