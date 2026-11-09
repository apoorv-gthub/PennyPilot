package in.apoorv.pennypilot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.apoorv.pennypilot.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository <ProfileEntity, Long>{
	
	
	// To tackle NullPointerException
	// select * from tbl_profiles where email = ?
	
	Optional<ProfileEntity> findByEmail(String email);

}
