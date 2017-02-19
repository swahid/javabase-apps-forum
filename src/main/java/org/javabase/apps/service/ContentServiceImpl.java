/**
 * 
 */
package org.javabase.apps.service;

import java.util.List;

import org.javabase.apps.entity.Content;
import org.javabase.apps.mapper.ContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
@Service
public class ContentServiceImpl implements ContentService{
    
    @Autowired
    ContentMapper contentMapper;

    @Override
    @Transactional(readOnly=true)
    public List<Content> getAllContent() {
        return contentMapper.getAllContent();
    }

    @Override
    @Transactional
    public Boolean addContent(Content content) {
        return contentMapper.addContent(content);
    }

    @Override
    @Transactional
    public Boolean updateContent(Content content) {
        return contentMapper.updateContent(content);
    }

    @Override
    @Transactional
    public Boolean deleteContent(Content contentId) {
        return contentMapper.deleteContent(contentId);
    }

	@Override
	@Transactional(readOnly=true)
	public Content getContentbyId(int id) {
		return contentMapper.getContentbyId(id);
	}

}
