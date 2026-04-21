import { useEffect, useState } from "react";

export default function Flights() {
  const [flights, setFlights] = useState<any[]>([]);
  const [flightName, setName] = useState("");
  const [source, setSource] = useState("");
  const [destination, setDestination] = useState("");
  const [popular, setPopular] = useState("");

  const loadFlights = () => {
    fetch("http://localhost:8087/flights")
      .then(res => res.json())
      .then(d => setFlights(d));
  };

  const loadPassengers = () => {
    fetch("http://localhost:8087/passengers")
      .then(res => res.json())
      .then(data => {
        const count: any = {};
        data.forEach((p: any) => {
          count[p.flightId] = (count[p.flightId] || 0) + 1;
        });

        let max = 0, id = "";
        for (let key in count) {
          if (count[key] > max) {
            max = count[key];
            id = key;
          }
        }

        setPopular(id);
      });
  };

  useEffect(() => {
    loadFlights();
    loadPassengers();
  }, []);

  const addFlight = async () => {
    await fetch("http://localhost:8087/flights", {
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify({
        flightName: flightName,
        source,
        destination,
        date: "2026-04-10",
        price: 5000
      }),
    });

    loadFlights();
  };

  const del = async (id: string) => {
    await fetch(`http://localhost:8087/flights/${id}`, {
      method: "DELETE",
    });
    loadFlights();
  };

  return (
    <div>
      <h2>Flights</h2>

      {/* ADD */}
      <input placeholder="Name" onChange={e => setName(e.target.value)} />
      <input placeholder="Source" onChange={e => setSource(e.target.value)} />
      <input placeholder="Destination" onChange={e => setDestination(e.target.value)} />
      <button onClick={addFlight}>Add</button>

      <h3>🔥 Popular Flight ID: {popular}</h3>

      {/* VIEW */}
      {flights.map(f => (
        <div key={f.id} style={{ border: "1px solid black", margin: "10px" }}>
          <p>{f.flightName} ({f.source} → {f.destination})</p>

          {f.id === popular && <b>Most Booked</b>}

          <button onClick={() => del(f.id)}>Delete</button>
        </div>
      ))}
    </div>
  );
}

