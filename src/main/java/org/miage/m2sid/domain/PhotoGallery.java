package org.miage.m2sid.domain;

import org.apache.tomcat.util.codec.binary.Base64;
import org.miage.m2sid.service.dto.PhotoGalleryDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A PhotoGallery.
 */
@Entity
@Table(name = "photoGallery")
public class PhotoGallery implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "latitude")
    private Float latitude;
    
    @Column(name = "image")
    private byte[] image;
    
    public PhotoGallery(PhotoGalleryDTO dto) {
		this.image=Base64.encodeBase64(dto.getImage().getBytes());
		this.latitude=dto.getLatitude();
		this.longitude=dto.getLongitude();
		this.pseudo=dto.getPseudo();
	}


    public PhotoGallery() {
	}

 
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PhotoGallery livre = (PhotoGallery) o;
        if(livre.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, livre.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
