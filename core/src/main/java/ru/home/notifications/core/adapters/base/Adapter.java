package ru.home.notifications.core.adapters.base;


import ru.home.notifications.core.exceptions.AdapterNotFoundException;

public enum Adapter
{
	EMAIL(1, "Email"),
	SMS(2, "SMS");

	private final int id;
	private final String name;

	Adapter(int id, String description)
	{
		this.id = id;
		this.name = description;
	}

	public String getName()
	{
		return name;
	}

	public int getId()
	{
		return id;
	}

	public static Adapter getById(int id)
	{
		for (Adapter e : values())
		{
			if (e.id == id) return e;
		}
		throw new AdapterNotFoundException(id);
	}

	public static Adapter getByName(String name)
	{
		for (Adapter e : values())
		{
			if (e.name.toUpperCase().equalsIgnoreCase(name)) return e;
		}
		throw new AdapterNotFoundException(name);
	}
}
