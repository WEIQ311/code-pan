package com.pan.config;

import com.pan.param.Node;
import com.pan.param.Thumbnail;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 接收application.yml中的file-manager下面的属性
 *
 * @author weiqiang
 */
@Component
@ConfigurationProperties(prefix = "file-manager")
public class ElfinderConfiguration {

    private Thumbnail thumbnail;

    private List<Node> volumes;

    /**
     * 默认不限制
     */
    private Long maxUploadSize = -1L;

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<Node> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<Node> volumes) {
        this.volumes = volumes;
    }

    public Long getMaxUploadSize() {
        return maxUploadSize;
    }

    public void setMaxUploadSize(Long maxUploadSize) {
        this.maxUploadSize = maxUploadSize;
    }
}
