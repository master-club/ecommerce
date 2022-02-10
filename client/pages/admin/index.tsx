import type { NextPage } from 'next';
import Main from './components/layout/main/main';
import Nav from './components/layout/nav/nav';
import Topbar from './components/layout/topbar/topbar';

import styles from './index.module.scss';

interface IProps {}

const AdminPage: NextPage<IProps> = props => {
  return (
    <div className={styles.app}>
      <Topbar />
      <div className={styles.wrapper}>
        <Nav />
        <Main />
      </div>
    </div>
  );
};

export default AdminPage;
