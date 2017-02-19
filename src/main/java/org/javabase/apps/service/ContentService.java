/**
 * 
 */
package org.javabase.apps.service;

import java.util.List;

import org.javabase.apps.entity.Content;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
public interface ContentService {
    
    public List<Content> getAllContent();
    public Content getContentbyId(int id);
    public Boolean addContent(Content content);
    public Boolean updateContent(Content content);
    public Boolean deleteContent(Content contentId);

}
