/**
 * 
 */
package org.javabase.apps.mapper;

import java.util.List;

import org.javabase.apps.entity.Thread;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
public interface ThreadMapper {
    
    public List<Thread> getAllThread();
    public Thread getThreadbyId(int id);
    public Boolean addThread(Thread thread);
    public Boolean updateThread(Thread thread);
    public Boolean deleteThread(Thread thread);

}
