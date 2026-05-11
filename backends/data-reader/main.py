import os

import pandas as pd
from dotenv import load_dotenv
from sqlalchemy import Boolean, Column, Float, Integer, String, create_engine
from sqlalchemy.orm import declarative_base, sessionmaker

load_dotenv()

user = os.environ["DB_USER"]
password = os.environ["DB_PASSWORD"]
host = os.environ["DB_HOST"]
port = os.environ["DB_PORT"]
db_database = os.environ["DB_DATABASE"]

DB_URL = f"postgresql://{user}:{password}@{host}:{port}/{db_database}"
engine = create_engine(DB_URL)
Base = declarative_base()
Session = sessionmaker(bind=engine)


class Track(Base):
    __tablename__ = "spotify_tracks"
    id = Column(Integer, primary_key=True)
    track_id = Column(String)
    artists = Column(String)
    album_name = Column(String)
    track_name = Column(String)
    popularity = Column(Integer)
    duration_ms = Column(Integer)
    explicit = Column(Boolean)
    danceability = Column(Float)
    energy = Column(Float)
    key = Column(String)
    loudness = Column(Float)
    mode = Column(Integer)
    speechiness = Column(Float)
    acousticness = Column(Float)
    instrumentalness = Column(Float)
    liveness = Column(Float)
    valence = Column(Float)
    tempo = Column(Float)
    time_signature = Column(Integer)
    track_genre = Column(String)


Base.metadata.create_all(engine)


def load_data_orm():
    df = pd.read_csv("../data/spotify_dataset.csv")

    df.to_sql(Track.__tablename__, con=engine, if_exists="replace", index=False)
    print("Data loaded via ORM-mapped table.")


if __name__ == "__main__":
    load_data_orm()
