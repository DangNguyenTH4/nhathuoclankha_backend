package nhathuoclankha.mapper;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Mapper<Entity, Dto> {

	public List<Dto> toListDto(List<Entity> e) {
		List<Dto> listDto = null;
		if(e!=null)
			listDto = e.parallelStream().map(this::toDto).collect(Collectors.toList());
		return listDto;
	}

	public List<Entity> toListEntity(List<Dto> d) {
		List<Entity> listDto = null;
		if(d!=null)
			listDto = d.parallelStream().map(this::toEntity).collect(Collectors.toList());
		return listDto;
	}

	public abstract Entity toEntity(Dto d);

	public abstract Dto toDto(Entity e);
}
