import { useEffect, useState } from "react";

export default function Passengers() {
  const [passengers, setPassengers] = useState<any[]>([]);
  const [flights, setFlights] = useState<any[]>([]);
  const [passengerName, setName] = useState("");
  const [flightId, setFlightId] = useState("");

  // LOAD DATA
  const load = async () => {
    const p = await fetch("http://localhost:8087/passenger/allPassengers").then(r => r.json());
    const f = await fetch("http://localhost:8087/flights").then(r => r.json());

    setPassengers(p);
    setFlights(f);
  };

  useEffect(() => {
    load();
  }, []);

  // ADD
  const add = async () => {
    await fetch("http://localhost:8087/passenger", {
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify({
        passengerName,
        age: 20,
        gender: "Female",
        flightId
      }),
    });

    load();
  };

  // DELETE
  const del = async (id: string) => {
    await fetch(`http://localhost:8087/passenger/${id}`, {
      method: "DELETE",
    });
    load();
  };

  // 🔥 FIND FLIGHT DETAILS
  const getFlight = (id: string) => {
    return flights.find(f => f.id === id);
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Passengers</h2>

      {/* ADD */}
      <input placeholder="Name" onChange={e => setName(e.target.value)} />
      <input placeholder="Flight ID" onChange={e => setFlightId(e.target.value)} />
      <button onClick={add}>Add</button>

      {/* CARD UI */}
      <div style={{ display: "flex", flexWrap: "wrap" }}>
        {passengers.map(p => {
          const flight = getFlight(p.flightId);

          return (
            <div
              key={p.id}
              style={{
                border: "1px solid black",
                borderRadius: "10px",
                padding: "15px",
                margin: "10px",
                width: "250px",
                backgroundColor: "#f5f5f5"
              }}
            >
              <h3>{p.name}</h3>

              {flight ? (
                <>
                  <p><b>{flight.flightName}</b></p>
                  <p>{flight.source} → {flight.destination}</p>
                  <p>{flight.date}</p>
                </>
              ) : (
                <p style={{ color: "red" }}>Flight not found</p>
              )}

              <button onClick={() => del(p.id)}>Delete</button>
            </div>
          );
        })}
      </div>
    </div>
  );
}