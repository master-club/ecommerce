import type { NextPage } from 'next';
import Image from 'next/image';
import styles from './nav.module.scss';

interface IProps {}

const Nav: NextPage<IProps> = props => {
  return (
    <nav className={styles.nav}>
      <div className={styles.wrapper}></div>
    </nav>
  );
};

export default Nav;
