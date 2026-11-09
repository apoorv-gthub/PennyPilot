package in.apoorv.pennypilot.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import in.apoorv.pennypilot.dto.ProfileDTO;
import in.apoorv.pennypilot.entity.ProfileEntity;
import in.apoorv.pennypilot.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileService {
	
	private final ProfileRepository profileRepository;
	
	public ProfileDTO registerProfile(ProfileDTO profileDTO) {
		ProfileEntity newProfile = toEntity(profileDTO);
		newProfile.setActivationToken(UUID.randomUUID().toString());
		newProfile = profileRepository.save(newProfile);
		return toDTO(newProfile);
		
	}
	
	public ProfileEntity toEntity(ProfileDTO profileDTO) {
		return ProfileEntity.builder()
				.id(profileDTO.getId())
				.fullName(profileDTO.getFullName())
				.email(profileDTO.getEmail())
				.password(profileDTO.getPassword())
				.profileImageUrl(profileDTO.getProfileImageUrl())
				.createdAt(profileDTO.getCreatedAt())
				.updatedAt(profileDTO.getUpdatedAt())
				.build();
	}
	
	public ProfileDTO toDTO(ProfileEntity profileEntity) {
		return ProfileDTO.builder()
				.id(profileEntity.getId())
				.fullName(profileEntity.getFullName())
				.email(profileEntity.getEmail())
				.profileImageUrl(profileEntity.getProfileImageUrl())
				.createdAt(profileEntity.getCreatedAt())
				.updatedAt(profileEntity.getUpdatedAt())
				.build();
	}
}
