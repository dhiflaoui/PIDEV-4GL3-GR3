package tn.esprit.PidevService.Interf;

import java.util.List;

import javax.ejb.Local;

@Local
public interface IBaseEntityLocalService<T> {

	public int add(T t);

	public List<T> getAll();

	public void deleteById(Long id);

	public void update(T t);
}
