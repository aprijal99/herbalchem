import AboutSection from '../components/home_components/AboutSection';
import StatisticSection from '../components/home_components/StatisticSection';
import SearchSection from '../components/home_components/SearchSection';
import {wrapper} from '../store';
import validateToken from '../functions/validateToken';

const Home = () => {
  return (
    <>
      <SearchSection />
      <StatisticSection />
      <AboutSection />
    </>
  );
}

export const getServerSideProps = wrapper.getServerSideProps(validateToken);

export default Home;