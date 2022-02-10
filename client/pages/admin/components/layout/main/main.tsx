import type { NextPage } from 'next';

import styles from './main.module.scss';

interface IProps {}

const Main: NextPage<IProps> = props => {
  return <main className={styles.main}>Hello from main</main>;
};

export default Main;
